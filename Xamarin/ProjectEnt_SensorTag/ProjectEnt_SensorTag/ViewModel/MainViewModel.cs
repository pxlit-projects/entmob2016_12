using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Views;
using System.Windows.Input;

namespace ProjectEnt_SensorTag.ViewModel
{
    /// <summary>
    /// This class contains properties that the main View can data bind to.
    /// <para>
    /// Use the <strong>mvvminpc</strong> snippet to add bindable properties to this ViewModel.
    /// </para>
    /// <para>
    /// You can also use Blend to data bind with the tool's support.
    /// </para>
    /// <para>
    /// See http://www.galasoft.ch/mvvm
    /// </para>
    /// </summary>
    public class MainViewModel : ViewModelBase
    {
        /// <summary>
        /// Initializes a new instance of the MainViewModel class.
        /// </summary>
        private static bool connected = false;

        public static bool Connected
        {
            get { return connected; }
            set { connected = value; }
        }

        private ICommand logIn;
        public ICommand LogIn
        {
            get { return logIn; }
            set { logIn = value; }
        }

        private ICommand register;
        public ICommand Register
        {
            get { return register; }
            set { register = value; }
        }

        private ICommand sensorTag;
        public ICommand SensorTag
        {
            get { return sensorTag; }
            set { sensorTag = value; }
        }

        private INavigationService nav;
        public INavigationService Nav
        {
            get { return nav; }
            set { nav = value; }
        }

        private ICommand regen;

        public ICommand Regen
        {
            get { return regen; }
            set { regen = value; }
        }

        public MainViewModel(INavigationService nav)
        {
            this.nav = nav;
            // configure Navigation
            SensorTag = new RelayCommand(() =>
            {
                this.nav.NavigateTo("SensorTagOverview");
            });
            Regen = new RelayCommand(() =>
            {
                this.nav.NavigateTo("Regen");
            });
        }
    }
}