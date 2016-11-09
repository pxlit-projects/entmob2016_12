using GalaSoft.MvvmLight;
using System;
using System.ComponentModel.DataAnnotations;

namespace ProjectEnt_SensorTag.Model
{
    public class Humidity : ObservableObject
    {
        public int Id { get; set; }
        public User User { get; set; }
        public int UserId { get; set; }
        public int LocationId { get; set; }

        private double humidityAmount;

        public double HumidityAmount
        {
            get { return humidityAmount; }
            set
            {
                Set(ref humidityAmount, value);
            }
        }
        public Byte[] Timestamp { get; set; }
    }
}
