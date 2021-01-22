using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PoliceService.Models
{
    public class RequestForm
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string UID { get; set; }

        public string FatherName { get; set; }

        public string Email { get; set; }
        public string Type { get; set; }
        public string Brand { get; set; }

        public string RegNum { get; set; }
    }
}
