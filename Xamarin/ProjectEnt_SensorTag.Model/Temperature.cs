using GalaSoft.MvvmLight;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.Model
{
    public class Temperature : ObservableObject
    {
        public int Id { get; set; }
        public int UserId { get; set; }
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

        [Timestamp]
        public Byte[] Timestamp { get; set; }
    }
}
