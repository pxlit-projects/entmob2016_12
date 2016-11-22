using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.Model
{
    public class User
    {
        [JsonProperty("Id")]
        public int Id { get; set; }
        [JsonProperty("Username")]
        public String Username { get; set; }
        [JsonProperty("Password")]
        public String Password { get; set; }
    }
}
