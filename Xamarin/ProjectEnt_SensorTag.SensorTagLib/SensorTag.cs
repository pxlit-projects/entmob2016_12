using GalaSoft.MvvmLight;
using ProjectEnt_SensorTag.SensorTagLib.Sensors;
using ProjectEnt_SensorTag.SensorTagLib.Services;

namespace ProjectEnt_SensorTag.SensorTagLib
{
    public class SensorTag : ObservableObject
    {
        private TemperatureSensor temperaturesensor = new TemperatureSensor();

        public TemperatureSensor TemperatureSensor
        {
            get { return temperaturesensor; }
            set
            {
                temperaturesensor = value;
                Set(() => TemperatureSensor, ref temperaturesensor, value);
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
