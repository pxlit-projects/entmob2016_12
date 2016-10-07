using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.Model
{
    public class User
    {
        [Key]
        public int Id { get; set; }
        public String Username { get; set; }
        public String Password { get; set; }
        public String Salt { get; set; }
    }
}
