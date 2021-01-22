using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PoliceService.Models
{
    public class Context : DbContext
    {
        public Context(DbContextOptions<Context> options) : base(options)
        {

        }

        public DbSet<WeaponCertificate> certificates { get; set; }
        public DbSet<Request> requests { get; set; }
        public DbSet<WeaponLicence> licences { get; set; }
        public DbSet<Person> people { get; set; }
        public DbSet<MedicalReport> reports { get; set; }
    }
}