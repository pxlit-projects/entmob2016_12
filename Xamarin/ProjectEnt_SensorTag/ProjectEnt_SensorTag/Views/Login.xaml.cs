using GalaSoft.MvvmLight.Messaging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class Login : ContentPage
    {
        public Login()
        {
            InitializeComponent();
            BindingContext = App.Locator.LoginViewModel;
            Messenger.Default.Register<string>(this, ShowWindow);
        }

        private void ShowWindow(string message)
        {
            DisplayAlert("Alert", message, "Ok");
        }

        protected override void OnDisappearing()
        {
            Messenger.Default.Unregister<string>(this);
            base.OnDisappearing();
        }
    }
}
