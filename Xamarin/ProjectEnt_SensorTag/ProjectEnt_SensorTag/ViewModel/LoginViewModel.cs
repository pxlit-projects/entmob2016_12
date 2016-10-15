using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Messaging;
using GalaSoft.MvvmLight.Views;
using PCLCrypto;
using ProjectEnt_SensorTag.Model;
using ProjectEnt_SensorTag.Network;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace ProjectEnt_SensorTag.ViewModel
{
    public class LoginViewModel : ViewModelBase
    {
        private User user = new User();

        public User User
        {
            get { return user; }
            set
            {
                user = value;
                RaisePropertyChanged(() => User);
            }
        }

        private RelayCommand login;

        public RelayCommand Login
        {
            get { return login; }
            set { login = value; }
        }

        private bool connect = true;

        public bool Connect
        {
            get { return connect; }
            set
            {
                connect = value;
            }
        }

        private INavigationService nav;

        public LoginViewModel(INavigationService nav)
        {
            this.nav = nav;
            Login = new RelayCommand(() =>
            {
                Connect = false;
                try
                {
                    User.Password = hashedPassword(User.Password);
                    bool result = SendMessage.PostRequest<bool,User>("UNKNOWN",User);
                    if (result)
                    {
                        Messenger.Default.Send<User>(User);
                        nav.GoBack();
                    }
                    else
                    {
                        Messenger.Default.Send("Login gegevens verkeerd");
                        User = new User();
                    }
                }
                catch
                {
                    Messenger.Default.Send("ERROR WITH SERVER: probeer later opnieuw");
                }
                Connect = true;
            }, () => Connect);
        }
        public String hashedPassword(String pass)
        {
            if (pass == null) pass = "random";
            var hasher = WinRTCrypto.HashAlgorithmProvider.OpenAlgorithm(HashAlgorithm.Sha1);
            byte[] inputBytes = Encoding.UTF8.GetBytes(pass);
            byte[] hash = hasher.HashData(inputBytes);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
            {
                sb.Append(hash[i].ToString("X2"));
            }
            return sb.ToString();
        }
    }
}