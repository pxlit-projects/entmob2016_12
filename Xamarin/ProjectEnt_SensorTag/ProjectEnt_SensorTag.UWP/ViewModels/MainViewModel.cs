using ProjectEnt_SensorTag.Model;
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
    class MainViewModel : INotifyPropertyChanged
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
                    Temperature temp = new Temperature();
                    User user = new User();
                    user.Id = 1;
                    user.Username = "ExampleUser";
                    temp.User = user;
                    temp.TemperatureAmount = 25.00;
                    temps.Add(temp);
                    TemperatureList = temps;
                }
                ,
                 s => true);
            }
        }
    }
}
