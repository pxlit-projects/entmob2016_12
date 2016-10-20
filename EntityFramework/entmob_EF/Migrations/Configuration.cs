namespace entmob_EF.Migrations
{
    using ProjectEnt_SensorTag.Model;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<entmob_EF.SensorContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(entmob_EF.SensorContext context)
        {
            var user = new User();
            user.Username = "User123";
            user.Password = "yolo";
            context.User.AddOrUpdate(user);
            context.SaveChanges();
        }
    }
}
