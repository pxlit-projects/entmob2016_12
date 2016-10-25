using GalaSoft.MvvmLight.Command;
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

        private ICommand _doSomething;

        public ICommand DoSomething
        {
            get
            {
                return _doSomething ??
                    new RelayCommand(() =>
                    {
                        _navigationService.Navigate(typeof(MainViewModel));
                    });
            }


        }
    }
}
