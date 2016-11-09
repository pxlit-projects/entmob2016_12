using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.Model
{
    public class UserLocation
    {
        public int Id { get; set; }
        public int UserId { get; set; }
        public User User { get; set; }
        public List<Temperature> Temperature { get; set; }
        public float Latitude { get; set; }
        public float Longitude { get; set; }
    }
}
