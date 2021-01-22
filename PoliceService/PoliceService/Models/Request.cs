using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace PoliceService.Models
{
    public class Request
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }
        public Person person { get; set; }
        public WeaponCertificate weaponCertificate { get; set; }
        public bool Paid { get; set; }

        public bool Processed { get; set; }
    }
}
