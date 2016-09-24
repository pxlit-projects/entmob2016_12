using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Robotics.Mobile.Core.Bluetooth.LE;

using Xamarin.Forms;
using System.Diagnostics;

namespace App6
{
    public class App : Application
    {
        static IAdapter _adapter;

        public static void SetAdapter(IAdapter adapter)
        {
            _adapter = adapter;
        }

        public App()
        {
            MainPage = new NavigationPage(new TestPage(_adapter));
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
    }
}
