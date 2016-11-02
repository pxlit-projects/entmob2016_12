using ProjectEnt_SensorTag.UWP.Navigation;
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
                    _navigationService.Navigate(typeof(Views.OverviewView));
                }
                ,
                 s => true);
                //user doorsturen
            }


        }
    }
}
