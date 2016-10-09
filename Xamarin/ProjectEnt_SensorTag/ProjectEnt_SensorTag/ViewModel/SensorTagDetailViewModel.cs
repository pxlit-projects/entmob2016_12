using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Command;
using GalaSoft.MvvmLight.Messaging;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectEnt_SensorTag.ViewModel
{
    public class SensorTagDetailViewModel : ViewModelBase
    {
        public static IDevice Device { get; set; }
        private RelayCommand conntectToService;
        private bool isConnected = false;
        public SensorTagDetailViewModel()
        {
            conntectToService = new RelayCommand(ConntectToService, () => !isConnected);
        }

        private void ConntectToService()
        {
            throw new NotImplementedException();
        }
    }
}
