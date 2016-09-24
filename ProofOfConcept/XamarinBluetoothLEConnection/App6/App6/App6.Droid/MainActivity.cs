
using Android.App;
using Android.Content.PM;
using Android.OS;

namespace App6.Droid
{
    [Activity(Label = "App6", Icon = "@drawable/icon", Theme = "@style/MainTheme", MainLauncher = true, ConfigurationChanges = ConfigChanges.ScreenSize | ConfigChanges.Orientation)]
    public class MainActivity : global::Xamarin.Forms.Platform.Android.FormsAppCompatActivity
    {
        protected override void OnCreate(Bundle bundle)
        {
            TabLayoutResource = Resource.Layout.Tabbar;
            ToolbarResource = Resource.Layout.Toolbar;
           
            base.OnCreate(bundle);

            global::Xamarin.Forms.Forms.Init(this, bundle);
            SetAdapter();

            LoadApplication(new App());
        }

        void SetAdapter()
        {
            var adapter = new Robotics.Mobile.Core.Bluetooth.LE.Adapter();
            App.SetAdapter(adapter);
        }
    }
}

