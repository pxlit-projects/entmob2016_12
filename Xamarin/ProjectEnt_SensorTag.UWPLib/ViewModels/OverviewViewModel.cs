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
using System.Security;

namespace ProjectEnt_SensorTag.UWP.ViewModels
{
    public class OverviewViewModel : INotifyPropertyChanged
    {
        private INavigationService _navigationService;
        private User user;

        public event PropertyChangedEventHandler PropertyChanged;

        public void OnPropertyChanged(string propertyName)
        {
            var handler = PropertyChanged;
            if (handler != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        public OverviewViewModel(INavigationService navigationService)
        {
            _navigationService = navigationService;

            //Receive user
            Messenger.Default.Register<User>(null, user => this.user = user);

        }

        private ICommand goBack;

        public ICommand GoBack
        {
            get
            {
                return goBack ??

                new CustomCommand(s =>
                {

                    Messenger.Default.Send<User>(user);

                    _navigationService.Navigate(typeof(MenuView));

                }
                ,
                 s => true);
            }
        }

        private ICommand changePassword;

        public ICommand ChangePassword
        {
            get
            {
                return changePassword ??

                new CustomCommand(s =>
                {
                    if (NotNullOrEmpty(newPassword) && NotNullOrEmpty(confirmPassword))
                    {
                        if (newPassword.Equals(confirmPassword))
                        {
                            if (newPassword.Length < 6)
                            {
                                ErrorMessage = "Min. 6 karakters.";
                            } else
                            {
                                ErrorMessage = "Wachtwoord gewijzigd.";
                                user.Password = newPassword;
                            }
                            
                        }
                        else
                        {
                            ErrorMessage = "Wachtwoorden komen niet overeen.";
                        }
                    } else
                    {
                        ErrorMessage = "Je moet wel iets invullen.";
                    }
                    
                    

                }
                ,
                 s => true);
            }
        }

        private String newPassword;
        public String NewPassword
        {
            get { return newPassword; }
            set { newPassword = value; }
        }

        private String errorMessage;

        public String ErrorMessage
        {
            get { return errorMessage; }
            set { errorMessage = value; OnPropertyChanged("ErrorMessage"); }
        }

        private String confirmPassword;

        public String ConfirmPassword
        {
            get { return confirmPassword; }
            set { confirmPassword = value; }
        }

        private Boolean NotNullOrEmpty(String tekst)
        {
            return tekst != null && tekst != String.Empty;
        }

    }

}

