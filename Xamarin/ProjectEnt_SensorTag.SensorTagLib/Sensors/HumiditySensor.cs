using ProjectEnt_SensorTag.Model;
using ProjectEnt_SensorTag.SensorTagLib.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Sensors
{
    public class HumiditySensor : HumidityService, INotifyPropertyChanged
    {
        private Humidity humidity = new Humidity();

        public event PropertyChangedEventHandler PropertyChanged;

        public Humidity Humidity
        {
            get { return humidity; }
            set
            {
                humidity = value;
                RaisePropertyChanged("Humidity");
            }
        }

        private void RaisePropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public HumiditySensor()
        {
            DiscoverServicesHumdidity();
        }
        public void GetHumidity()
        {
            humidityCharConfig.Write(new byte[] { 0x01 });
            humidityChar.StartUpdates();
            Humidity.HumidityAmount = CalculateHumidity();
            humidityChar.StopUpdates();
            humidityCharConfig.Write(new byte[] { 0x00 });
        }

        public double CalculateHumidity()
        {
            if (humidityChar.Value == null) return 0;
            var sensorData = humidityChar.Value;
            int a = BitConverter.ToUInt16(sensorData, 2);
            a = a - (a % 4);
            double humidity = (-6f) + 125f * (a / 65535f);
            var t = (sensorData[0] & 0xff) | ((sensorData[1] << 8) & 0xff00);
            return Math.Round(humidity, 1);
        }
    }
}
