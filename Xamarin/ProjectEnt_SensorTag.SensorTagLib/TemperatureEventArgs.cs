using System;

namespace ProjectEnt_SensorTag.SensorTagLib
{
    public class TemperatureEventArgs : EventArgs
    {
        public TemperatureEventArgs(double infrared, DateTimeOffset timestamp)
        {
            Infrared = infrared;
            Timestamp = timestamp;
        }

        public DateTimeOffset Timestamp
        {
            get;
            private set;
        }

        public double Infrared
        {
            get;
            private set;
        }
    }
}