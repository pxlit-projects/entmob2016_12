/*
  In App.xaml:
  <Application.Resources>
      <vm:ViewModelLocator xmlns:vm="clr-namespace:ProjectEnt_SensorTag"
                           x:Key="Locator" />
  </Application.Resources>
  
  In the View:
  DataContext="{Binding Source={StaticResource Locator}, Path=ViewModelName}"

  You can also use Blend to do all this with the tool's support.
  See http://www.galasoft.ch/mvvm
*/

using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Ioc;
using GalaSoft.MvvmLight.Views;
using Microsoft.Practices.ServiceLocation;
using ProjectEnt_SensorTag;
using ProjectEnt_SensorTag.Navigation;
using ProjectEnt_SensorTag.View;
using ProjectEnt_SensorTag.Views;

namespace ProjectEnt_SensorTag.ViewModel
{
    /// <summary>
    /// This class contains static references to all the view models in the
    /// application and provides an entry point for the bindings.
    /// </summary>
    public class ViewModelLocator
    {
        /// <summary>
        /// Initializes a new instance of the ViewModelLocator class.
        /// 
        /// Singleton?????
        /// </summary>
        private const string home = "Home";
        private const string sensorTagDetail = "SensorTagDetail";
        private const string sensorTagOverview = "SensorTagOverview";
        private const string regen = "Regen";
        private const string login = "Login";
        private const string register = "Register";

        public ViewModelLocator()
        {
            ServiceLocator.SetLocatorProvider(() => SimpleIoc.Default);

            nav = new NavigationService();
            nav.Configure(home, typeof(Home));
            nav.Configure(sensorTagDetail, typeof(SensorTagDetail));
            nav.Configure(sensorTagOverview, typeof(SensorTagOverview));
            nav.Configure(regen, typeof(Regen));
            nav.Configure(login, typeof(Login));
            nav.Configure(register, typeof(Register));

            SimpleIoc.Default.Register<INavigationService>(() => nav);

            SimpleIoc.Default.Register<SensorTagDetailViewModel>();
            SimpleIoc.Default.Register<SensorTagViewModel>();
            SimpleIoc.Default.Register<MainViewModel>();
            SimpleIoc.Default.Register<RegenViewModel>();
            SimpleIoc.Default.Register<LoginViewModel>();
            SimpleIoc.Default.Register<RegisterViewModel>();
        }

        public NavigationService nav;
        public MainViewModel Main
        {
            get
            {
                return ServiceLocator.Current.GetInstance<MainViewModel>();
            }
        }
        public SensorTagDetailViewModel SensorTagDetailViewModel
        {
            get
            {
                return ServiceLocator.Current.GetInstance<SensorTagDetailViewModel>();
            }
        }
        public SensorTagViewModel SensorTagViewModel
        {
            get
            {
                return ServiceLocator.Current.GetInstance<SensorTagViewModel>();
            }
        }
        public RegenViewModel RegenViewModel
        {
            get
            {
                return ServiceLocator.Current.GetInstance<RegenViewModel>();
            }
        }
        public RegisterViewModel RegisterViewModel
        {
            get
            {
                return ServiceLocator.Current.GetInstance<RegisterViewModel>();
            }
        }
        public LoginViewModel LoginViewModel
        {
            get
            {
                return ServiceLocator.Current.GetInstance<LoginViewModel>();
            }
        }
        public static void Cleanup()
        {
            // TODO Clear the ViewModels
            SimpleIoc.Default.Unregister<SensorTagDetailViewModel>();
            SimpleIoc.Default.Unregister<SensorTagViewModel>();
            SimpleIoc.Default.Unregister<MainViewModel>();
            SimpleIoc.Default.Unregister<RegenViewModel>();
            SimpleIoc.Default.Unregister<LoginViewModel>();
            SimpleIoc.Default.Unregister<RegisterViewModel>();
        }
    }
}