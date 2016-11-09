using ProjectEnt_SensorTag.Model;
using System.Data.Entity;
using System.Data.Entity.Infrastructure.Annotations;

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
            modelBuilder.Entity<User>().Property(t => t.Username).IsRequired().HasMaxLength(60);
            modelBuilder.Entity<User>().Property(t => t.Password).IsRequired().HasMaxLength(60);
            modelBuilder.Entity<Temperature>().HasOptional(s => s.Location).WithRequired();
            modelBuilder.Entity<User>().ToTable("Users");
            modelBuilder.Entity<Temperature>().HasRequired(t => t.User).WithMany();
        }
    }
}
