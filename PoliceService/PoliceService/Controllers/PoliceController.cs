﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using PoliceService.Models;

namespace PoliceService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PoliceController : ControllerBase
    {
        private Context _context;
        private IHttpClientFactory _clientFactory;

        public PoliceController(Context context, IHttpClientFactory clientFactory)
        {
            _context = context;
            _clientFactory = clientFactory;
        }

        // GET: api/Police
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/Police/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Police
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT: api/Police/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }

        public void AddWeaponCertificate(WeaponCertificate wr)
        {
            _context.certificates.Add(wr);
        }

        public WeaponCertificate GetWeaponCertificate(int id)
        {
            return _context.certificates.Find(id);
        }

        public void AddRequest(Request r)
        {
            _context.requests.Add(r);
            _context.SaveChanges();
        }

        public void AddWeaponLicence(WeaponLicence wl)
        {
            _context.licences.Add(wl);
            _context.SaveChanges();
        }

        public void RequestProcessed(Request r)
        {
            r.Processed = true;
            _context.requests.Update(r);
            _context.SaveChanges();
        }

        [HttpPost]
        [Route("SendRequest12")]
        public void SendRequest12(string data)
        {

        }


        [HttpPost]
        [Route("SendRequest")]
        public void SendRequest(Request request)
        {

            AddRequest(request);

            // proveriti podatke centralnom registru
            bool res = SendCS(request.person);

            if(!res)
            {
                return;
            }

            if (CheckWeaponCerticifate(request.weaponCertificate))
            {
                // obavesti korisnika
                return;
            }

            if (!request.Paid)
            {
                // obavesti korisnika
                return;
            }

            WeaponLicence licence = new WeaponLicence();
            licence.DateOfIssue = DateTime.Now;
            licence.ValidUntil = licence.DateOfIssue.AddYears(5);
            licence.FirstName = request.person.FirstName;
            licence.LastName = request.person.LastName;

            licence.RegistrationNumber = "";

            RequestProcessed(request);

            AddWeaponLicence(licence);
            //obavesti korisnika
        }

        public bool CheckWeaponCerticifate(WeaponCertificate list)
        {
            if (string.IsNullOrEmpty(list.Type) || string.IsNullOrEmpty(list.RegistrationNumber) || string.IsNullOrEmpty(list.Brand))
            {
                return false;
            }

            return true;
        }

        public bool DaLiPostojiSacuvanIzvestaj(string jmbg)
        {
            return true;
        }

        public bool SendCS(Person p)
        {
            string uri = "https://89ffeb12-d87d-4950-874e-22469d02e235.mock.pstmn.io"; //"http://localhost:59801/myHome";
            var request = new HttpRequestMessage(HttpMethod.Post, uri);
            request.Content = new StringContent(JsonConvert.SerializeObject(p), Encoding.UTF8, "application/json");
            var client = _clientFactory.CreateClient("coreService");
            var response = client.SendAsync(request);
          //  if (response.IsSuccessStatusCode)
          if(response.Result.StatusCode == HttpStatusCode.OK)
            {//response.Result.Content
                var responseContent =  response.Result.Content.ReadAsStringAsync();
                CheckResult merchant = JsonConvert.DeserializeObject<CheckResult>(responseContent.Result);
                //return merchant;
                return merchant.res;
            }

            return false;
        }


    }
}
