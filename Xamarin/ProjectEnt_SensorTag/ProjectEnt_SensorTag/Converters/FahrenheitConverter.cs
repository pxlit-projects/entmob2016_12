using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Converters
{
    class FahrenheitConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            int fahrenheit = int.Parse((String)value);
            return fahrenheit * 9 / 5 + 32;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            int fahrenheit = int.Parse((String)value);
            return fahrenheit / 1.8 - 32;
        }
    }
}
