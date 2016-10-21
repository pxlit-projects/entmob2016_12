using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Messaging;
using GalaSoft.MvvmLight.Views;
using ProjectEnt_SensorTag.Model;
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

        public static bool Conntected
        {
            get { return connected; }
            set
            {
                connected = value;
             }
        }
        
        private RelayCommand sensorTag;
        public RelayCommand SensorTag
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

        private RelayCommand regen;

        public RelayCommand Regen
        {
            get { return regen; }
            set { regen = value; }
        }

        private User user;

        public User User
        {
            get { return user; }
            set
            {
                user = value;
                RaisePropertyChanged(() => User);
                Login.RaiseCanExecuteChanged();
                Register.RaiseCanExecuteChanged();
            }
        }

        private RelayCommand login;

        public RelayCommand Login
        {
            get { return login; }
            set { login = value; }
        }

        private RelayCommand register;

        public RelayCommand Register
        {
            get { return register; }
            set { register = value; }
        }

        public MainViewModel(INavigationService nav)
        {
            this.nav = nav;
            Messenger.Default.Register<User>(this, (e) => User=e);

            // configure Navigation
            SensorTag = new RelayCommand(() =>
            {
                if (!Conntected)
                {
                    this.nav.NavigateTo("SensorTagOverview");
                }
                else
                {
                    Messenger.Default.Send("U bent al verbonden met de SensorTag");
                }
            });
            Regen = new RelayCommand(() =>
            {
                if (Conntected)
                {
                    try
                    {
                        this.nav.NavigateTo("Regen");
                        Messenger.Default.Send(User);
                    }
                    catch
                    {
                        Messenger.Default.Send("Unknown error restart connection");
                        Conntected = false;
                    }
                }
                else
                {
                    Messenger.Default.Send("Meld u eerst aan en verbind met de sensorTag");
                }
            });
            Login = new RelayCommand(() =>
            {
                this.nav.NavigateTo("Login");
            },() => User == null);
            Register = new RelayCommand(() =>
            {
                this.nav.NavigateTo("Register");
            }, () => User == null);
        }
    }
}