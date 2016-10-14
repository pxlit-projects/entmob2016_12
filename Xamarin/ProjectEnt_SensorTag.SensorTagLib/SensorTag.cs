using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using GalaSoft.MvvmLight;

namespace ProjectEnt_SensorTag.SensorTagLib
{
    public class SensorTag : ObservableObject
    {
        private Temperature temperature = new Temperature();

        public Temperature Temperature
        {
            get { return temperature; }
            set
            {
                temperature = value;
                Set(() => Temperature, ref temperature, value);
            }
        }
    }
}
