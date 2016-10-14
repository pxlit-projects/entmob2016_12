using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Exceptions
{
    class UnknownDeviceException : Exception
    {
        public UnknownDeviceException(string message) : base(message)
        {

        }
    }
}
