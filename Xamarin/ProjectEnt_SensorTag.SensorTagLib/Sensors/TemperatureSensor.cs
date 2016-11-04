﻿using ProjectEnt_SensorTag.Model;
using ProjectEnt_SensorTag.SensorTagLib.Services;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib.Sensors
{
    public class TemperatureSensor : TemperatureService, INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        private List temperature = new List();
        public List Temperature
        {
            get { return temperature; }
            set
            {
                temperature = value;
                RaisePropertyChanged("Temperature");
            }
        }

        private void RaisePropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public TemperatureSensor()
        {
            DiscoverServicesTemperature();
        }

        public void GetTemperature()
        {
            temperatureCharConfig.Write(new byte[] { 0x01 });
            temperatureChar.StartUpdates();
            Temperature.TemperatureAmount = CalculateTemperature();
            temperatureChar.StopUpdates();
            temperatureCharConfig.Write(new byte[] { 0x00 });
        }
        private Double CalculateTemperature()
        {
            if (temperatureChar.Value == null) return 0;
            var data = temperatureChar.Value;

            short objTemp = (short)((short)data[0] + (short)(data[1] << 8));
            short dieTemp = (short)((short)data[2] + (short)(data[3] << 8));

            const double SCALE_LSB = 0.03125;
            int it;

            it = (int)((objTemp) >> 2);
            double ir = (double)it * SCALE_LSB;

            it = (int)((dieTemp) >> 2);
            double ambient = (double)it * SCALE_LSB;

            Debug.WriteLine("ambient: " + ambient + "\nIR: " + ir + " C");
            return ir;
        }
    }
}
