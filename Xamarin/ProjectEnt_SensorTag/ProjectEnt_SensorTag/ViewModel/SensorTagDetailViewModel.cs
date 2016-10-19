using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Messaging;
using GalaSoft.MvvmLight.Views;
using ProjectEnt_SensorTag.SensorTagLib;
using ProjectEnt_SensorTag.SensorTagLib.Devices;
using ProjectEnt_SensorTag.SensorTagLib.Services;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Xamarin.Forms;

namespace ProjectEnt_SensorTag.ViewModel
{
    public class SensorTagDetailViewModel : ViewModelBase
    {
        private IDevice device;
        public IDevice Device
        {
            get { return device; }
            set
            {
                device = value;
                RaisePropertyChanged(() => Device);
            }
        }
        private ICommand connectToService;
        public ICommand ConnectToService
        {
            get { return connectToService; }
            set { connectToService = value; }
        }
        private INavigationService nav;
        public SensorTagDetailViewModel(INavigationService nav)
        {
            this.nav = nav;
            Messenger.Default.Register<IDevice>(this,GetDevice);
            connectToService = new RelayCommand(ConntectToService);
        }

        private void GetDevice(IDevice device)
        {
            Device = device;
        }

        private void ConntectToService()
        {
            MainViewModel.Conntected = true;
            DeviceEssentials.device = device;
            DeviceSetup.ConnectToDevice();

            nav.GoBack();
            nav.GoBack();
        }
    }
}
