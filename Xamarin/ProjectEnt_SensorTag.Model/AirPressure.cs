﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.Model
{
    public class AirPressure
    { 
    [Key]
    public int Id { get; set; }
    public User User { get; set; }
    public int UserId { get; set; }
    public int LocationId { get; set; }
    public int Presure { get; set; }
    [Timestamp]
    public Byte[] Timestamp { get; set; }
    }
}
