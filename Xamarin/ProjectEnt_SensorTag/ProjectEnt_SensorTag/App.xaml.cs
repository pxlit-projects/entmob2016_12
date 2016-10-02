using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag
{
    public partial class App : Application
    {
        public static IAdapter adapter { get; private set; }

        public App()
        {
            InitializeComponent();

            MainPage = new Home();
        }

        protected override void OnStart()
        {
            // Handle when your app starts
        }

        protected override void OnSleep()
        {
            // Handle when your app sleeps
        }

        protected override void OnResume()
        {
            // Handle when your app resumes
        }

        public static void SetAdapter(IAdapter phoneadapter)
        {
            adapter = phoneadapter;
        }
    }
}
