using ProjectEnt_SensorTag.Model;
using ProjectEnt_SensorTag.UWP.Messaging;
using ProjectEnt_SensorTag.UWP.Navigation;
using ProjectEnt_SensorTag.UWP.Views;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace ProjectEnt_SensorTag.UWP.ViewModels
{
    public class MainViewModel : INotifyPropertyChanged
    {
        private INavigationService _navigationService;

        public event PropertyChangedEventHandler PropertyChanged;

        public void OnPropertyChanged(string propertyName)
        {
            var handler = PropertyChanged;
            if (handler != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        private List<Temperature> temperatureList = new List<Temperature>();

        public List<Temperature> TemperatureList
        {
            get { return temperatureList; }
            set
            {
                temperatureList = value;
                OnPropertyChanged("TemperatureList");
            }
        }


        public MainViewModel(INavigationService navigationService)
        {
            _navigationService = navigationService;

            //Receive user
            Messenger.Default.Register<User>(null, user => this.user = user);
        }

        private ICommand _changePassword;

        public ICommand ChangePassword
        {
            get
            {
                return _changePassword ??
                new CustomCommand(s =>
                {
                    _navigationService.Navigate(typeof(OverviewView));
                }
                ,
                 s => true);
            }
        }

        private ICommand _temp;

        public ICommand Temp
        {
            get
            {
                return _temp ??
                new CustomCommand(s =>
                {
                    List<Temperature> temps = new List<Temperature>();
                    
                    //Dummy data
                    Temperature temp = new Temperature();

                    //Dummy data User
                    User userDummy = new User();
                    userDummy.Id = 1;
                    userDummy.Username = "ExampleUser";

                    temp.User = userDummy;
                    temp.TemperatureAmount = 25.00;
                    temps.Add(temp);

                    Temperature temp2 = new Temperature();
                    temp2.User = user;
                    temp2.TemperatureAmount = 17.00;
                    temps.Add(temp2);

                    TemperatureList = temps;
                }
                ,
                 s => true);
            }
        }

        private User user;

        public User User
        {
            get { return user; }
            set { user = value; }
        }
    }
}
