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
            String item = value.ToString();
            Double fahrenheit = Double.Parse(item);
            return fahrenheit * 9 / 5 + 32 + "℉";
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            String item = value.ToString();
            Double fahrenheit = Double.Parse(item.Substring(0,item.Length-1));

            if(fahrenheit == 0)
            {
                return 0;
            }

            return fahrenheit / 1.8 - 32;
        }
    }
}
