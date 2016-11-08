
using ProjectEnt_SensorTag.UWP.Navigation;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using ProjectEnt_SensorTag.UWP.Views;

namespace ProjectEnt_SensorTag.UWP.ViewModels
{
    class LoginViewModel : INotifyPropertyChanged
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

        public LoginViewModel(INavigationService navigationService)
        {
            _navigationService = navigationService;
        }

        private ICommand login;

        public ICommand Login
        {
            get
            {
                return login ??
                new CustomCommand(s =>
                {
                    _navigationService.Navigate(typeof(MenuView));
                }
                ,
                 s => true);
            }
        }
    }
}
