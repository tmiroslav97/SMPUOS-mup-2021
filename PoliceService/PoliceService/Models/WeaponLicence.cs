using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace PoliceService.Models
{
    public class WeaponLicence
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }
        public string LastName { get; set; }
        public string FirstName { get; set; }
        public string RegistrationNumber { get; set; }
        public string Address { get; set; }
        public DateTime DateOfIssue { get; set; }
        public DateTime ValidUntil { get; set; }
    }
}
