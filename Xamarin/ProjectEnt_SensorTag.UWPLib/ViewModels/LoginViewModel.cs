﻿
using ProjectEnt_SensorTag.UWP.Navigation;
using ProjectEnt_SensorTag.UWP.Views;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
<<<<<<< HEAD:Xamarin/ProjectEnt_SensorTag/ProjectEnt_SensorTag.UWP/ViewModels/LoginViewModel.cs
using ProjectEnt_SensorTag.UWP.Views;
using ProjectEnt_SensorTag.Model;
using ProjectEnt_SensorTag.UWP.Messaging;
using Windows.UI.Popups;
=======
>>>>>>> 72012d3a94e5dd75774d49efbe5af01ac2619a38:Xamarin/ProjectEnt_SensorTag.UWPLib/ViewModels/LoginViewModel.cs

namespace ProjectEnt_SensorTag.UWP.ViewModels
{
    public class LoginViewModel : INotifyPropertyChanged
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

                user.Id = 1;


                return login ??

                new CustomCommand(s =>
                {
                    if (user.Username == null || user.Username.Length < 6)
                    {
                        ErrorMessage = "Username klopt niet.";
                    }
                    else
                    {
                        if (user.Password == null || user.Password.Length < 6)
                        {
                            //Messenger.Default.Send("Login gegevens zijn verkeerd");
                            ErrorMessage = "Wachtwoord klopt niet.";

                        }
                        else
                        {
                            Messenger.Default.Send<User>(user);

                            _navigationService.Navigate(typeof(MenuView));
                        }
                    }

                }
                ,
                 s => true);
            }
        }

        private User user = new User();

        public User User
        {
            get { return user; }
            set
            {
                user = value;
            }
        }

        private String errorMessage;

        public String ErrorMessage
        {
            get { return errorMessage; }
            set { errorMessage = value; OnPropertyChanged("ErrorMessage"); }
        }

    }
}