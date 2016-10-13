using ProjectEnt_SensorTag.SensorTagLib;
using ProjectEnt_SensorTag.View;
using ProjectEnt_SensorTag.ViewModel;
using ProjectEnt_SensorTag.Views;
using Robotics.Mobile.Core.Bluetooth.LE;
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
            var firstPage = new NavigationPage(new Home());

            Locator.nav.Initialize(firstPage);
            MainPage = firstPage;
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
            DeviceEssentials.localAdapter = phoneadapter;
        }
    }
}
