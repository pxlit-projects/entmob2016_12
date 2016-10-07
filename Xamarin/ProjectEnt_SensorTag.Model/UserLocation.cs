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
        public int userId { get; set; }
        public float latitude { get; set; }
        public float longitude { get; set; }
    }
}
