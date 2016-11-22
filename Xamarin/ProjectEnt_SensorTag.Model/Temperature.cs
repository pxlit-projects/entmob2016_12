using GalaSoft.MvvmLight;
using System;
using System.Collections.Generic;

namespace ProjectEnt_SensorTag.Model
{
    public class Temperature : ObservableObject
    {
        public int Id { get; set; }
        public int UserId { get; set; }
        public User User { get; set; }
        public List<int> LocationId { get; set; }
        public List<UserLocation> Location { get; set; }
        private double temperatureAmount;

        public double TemperatureAmount
        {
            get { return temperatureAmount; }
            set
            {
                Set(ref temperatureAmount,value);
            }
        }
        public Byte[] Timestamp { get; set; }
    }
}
