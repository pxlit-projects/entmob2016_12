using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Converters
{
    class KelvinConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            int celsius = int.Parse((String)value);
            return celsius + 273.15;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            int kelvin = int.Parse((String)value);
            return kelvin - 273.15;
        }
    }
}
