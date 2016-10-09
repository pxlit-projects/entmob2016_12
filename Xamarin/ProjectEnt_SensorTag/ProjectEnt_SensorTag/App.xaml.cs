using ProjectEnt_SensorTag.SensorTagLib;
using ProjectEnt_SensorTag.ViewModel;
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
        private static ViewModelLocator locator = new ViewModelLocator();

        public static ViewModelLocator Locator
        {
            get { return locator; }
            set { locator = value; }
        }

        public App()
        {
            InitializeComponent();

            MainPage = new NavigationPage(new Home());
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
            DeviceSetup.localAdapter = phoneadapter;
        }
    }
}
