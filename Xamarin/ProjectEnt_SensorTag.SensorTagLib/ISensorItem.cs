using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.SensorTagLib
{
    public interface ISensorItem<T>
    {
        T Info();

    }
}
