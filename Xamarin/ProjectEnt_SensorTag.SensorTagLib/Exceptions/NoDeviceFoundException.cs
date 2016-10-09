using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Exceptions
{
    public class NoDeviceFoundException : Exception
    {
        public NoDeviceFoundException(string message) : base(message)
        {
                
        }

    }
}
