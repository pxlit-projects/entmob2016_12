using GalaSoft.MvvmLight;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Devices
{
    public class DeviceEssentials
    {
        public static IAdapter localAdapter;
        public static IDevice device;
        #region temperature
        protected static Guid temperatureServiceUuid = Guid.Parse("f000aa00-0451-4000-b000-000000000000");
        protected static Guid temperatureCharacteristicUuid = Guid.Parse("f000aa01-0451-4000-b000-000000000000");
        protected static Guid temperatureCharacteristicConfigUuid = Guid.Parse("f000aa02-0451-4000-b000-000000000000");
        protected static Guid temperatureCharacteristicPeriodUuid = Guid.Parse("f000aa03-0451-4000-b000-000000000000");

        protected static ICharacteristic temperatureChar;
        protected static ICharacteristic temperatureCharConfig;
        protected static ICharacteristic temperatureCharPeriod;
        #endregion
        #region humidity
        protected static Guid humidityServiceUuid = Guid.Parse("f000aa20-0451-4000-b000-000000000000");
        protected static Guid humidityCharacteristicUuid = Guid.Parse("f000aa21-0451-4000-b000-000000000000");
        protected static Guid humidityCharacteristicConfigUuid = Guid.Parse("f000aa22-0451-4000-b000-000000000000");
        protected static Guid humidityCharacteristicPeriodUuid = Guid.Parse("f000aa23-0451-4000-b000-000000000000");

        protected static ICharacteristic humidityChar;
        protected static ICharacteristic humidityCharConfig;
        protected static ICharacteristic humidityCharPeriod;
        #endregion
    }
}
