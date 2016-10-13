using ProjectEnt_SensorTag.SensorTagLib.Services;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib
{
    public class Temperature : TemperatureService, ISensorItem<Temperature>, INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        private double degree = 0;
        public double Degree
        {
            get { return degree; }
            set
            {
                degree = value;
                RaisePropertyChanged("Degrees");
            }
        }

        private void RaisePropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        // Copy pasta ftw!
        public Temperature()
        {
            DiscoverServicesTemperature();
        }
        

        public Temperature Info()
        {

            temperatureCharConfig.Write(new byte[] { 0x01 }); // Turn ON
            temperatureChar.StartUpdates();


            return this;
        }
    }
}
