using ProjectEnt_SensorTag.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class Regen : ContentPage
    {
        public Regen()
        {
            InitializeComponent();
            BindingContext = App.Locator.RegenViewModel;
        }
    }
}
