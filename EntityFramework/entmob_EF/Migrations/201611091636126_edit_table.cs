namespace entmob_EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class edit_table : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.UserLocations",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        UserId = c.Int(nullable: false),
                        Latitude = c.Single(nullable: false),
                        Longitude = c.Single(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Users", t => t.UserId, cascadeDelete: true)
                .Index(t => t.UserId);
            
            CreateTable(
                "dbo.UserLocationTemperatures",
                c => new
                    {
                        UserLocation_Id = c.Int(nullable: false),
                        Temperature_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.UserLocation_Id, t.Temperature_Id })
                .ForeignKey("dbo.UserLocations", t => t.UserLocation_Id, cascadeDelete: true)
                .ForeignKey("dbo.Temperatures", t => t.Temperature_Id, cascadeDelete: true)
                .Index(t => t.UserLocation_Id)
                .Index(t => t.Temperature_Id);
            
            CreateIndex("dbo.Temperatures", "UserId");
            AddForeignKey("dbo.Temperatures", "UserId", "dbo.Users", "Id", cascadeDelete: true);
            DropColumn("dbo.Temperatures", "LocationId");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Temperatures", "LocationId", c => c.Int(nullable: false));
            DropForeignKey("dbo.Temperatures", "UserId", "dbo.Users");
            DropForeignKey("dbo.UserLocations", "UserId", "dbo.Users");
            DropForeignKey("dbo.UserLocationTemperatures", "Temperature_Id", "dbo.Temperatures");
            DropForeignKey("dbo.UserLocationTemperatures", "UserLocation_Id", "dbo.UserLocations");
            DropIndex("dbo.UserLocationTemperatures", new[] { "Temperature_Id" });
            DropIndex("dbo.UserLocationTemperatures", new[] { "UserLocation_Id" });
            DropIndex("dbo.UserLocations", new[] { "UserId" });
            DropIndex("dbo.Temperatures", new[] { "UserId" });
            DropTable("dbo.UserLocationTemperatures");
            DropTable("dbo.UserLocations");
        }
    }
}
