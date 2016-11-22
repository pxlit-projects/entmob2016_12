using System;

namespace ProjectEnt_SensorTag.Model
{
    public class AirPressure
    { 
    public int Id { get; set; }
    public User User { get; set; }
    public int UserId { get; set; }
    public int LocationId { get; set; }
    public int Presure { get; set; }
    public Byte[] Timestamp { get; set; }
    }
}
