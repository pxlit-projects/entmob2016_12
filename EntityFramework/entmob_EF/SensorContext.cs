using ProjectEnt_SensorTag.Model;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Data.Entity.Infrastructure.Annotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace entmob_EF
{
    class SensorContext : DbContext
    {
        public SensorContext() : base("sensorDB")
        {

        }

        public DbSet<User> User { get; set; }

        public DbSet<Temperature> Temperature { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<User>().HasKey(s => s.Id);
            modelBuilder.Entity<Temperature>().HasMany(s => s.Location).WithOptional().HasForeignKey(h => h.Id);
            modelBuilder.Entity<User>().ToTable("UserData");
        }
    }
}
