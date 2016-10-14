using GalaSoft.MvvmLight;
using ProjectEnt_SensorTag.SensorTagLib.Sensors;

namespace ProjectEnt_SensorTag.SensorTagLib
{
    public class SensorTag : ObservableObject
    {
        private TemperatureSensor temperature = new TemperatureSensor();

        public TemperatureSensor Temperature
        {
            get { return temperature; }
            set
            {
                temperature = value;
                Set(() => Temperature, ref temperature, value);
            }
        }
        private HumiditySensor humiditySensor = new HumiditySensor();

        public HumiditySensor HumiditySensor
        {
            get { return humiditySensor; }
            set
            {
                humiditySensor = value;
                Set(() => HumiditySensor, ref humiditySensor, value);
            }
        }
    }
}
