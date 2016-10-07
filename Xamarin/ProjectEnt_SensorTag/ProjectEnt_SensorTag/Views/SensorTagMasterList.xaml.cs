using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class SensorTagMasterList : MasterDetailPage
    {
        public SensorTagMasterList()
        {
            InitializeComponent();
            ObservableCollection<Object> list = new ObservableCollection<Object>();
            list.Add(new object());
        }
    }
}
