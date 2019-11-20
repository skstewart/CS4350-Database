import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class AdministratorView
{

	protected Shell shell;
	private Text txtTargutAdministratorView;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			AdministratorView window = new AdministratorView();
			window.open();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		shell = new Shell();
		shell.setMinimumSize(new Point(700, 500));
		shell.setSize(422, 261);
		shell.setText("Administrator View");

		txtTargutAdministratorView = new Text(shell, SWT.BORDER | SWT.CENTER);
		txtTargutAdministratorView.setFont(SWTResourceManager.getFont("Segoe UI", 32, SWT.NORMAL));
		txtTargutAdministratorView.setEnabled(false);
		txtTargutAdministratorView.setEditable(false);
		txtTargutAdministratorView.setText("Targut Administrator View");
		txtTargutAdministratorView.setBounds(48, 32, 576, 85);

		Button btnAddItem = new Button(shell, SWT.NONE);
		btnAddItem.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				AddItem addItem = new AddItem();
				addItem.open();
			}
		});
		btnAddItem.setText("Add Item");
		btnAddItem.setBounds(48, 176, 150, 100);

		Button btnRemoveItem = new Button(shell, SWT.NONE);
		btnRemoveItem.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				RemoveItem removeItem = new RemoveItem();
				removeItem.open();
			}
		});
		btnRemoveItem.setText("Remove Item");
		btnRemoveItem.setBounds(260, 176, 150, 100);

		Button btnViewCustomers = new Button(shell, SWT.NONE);
		btnViewCustomers.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				ViewCustomers customers = new ViewCustomers();
				customers.open();
			}
		});
		btnViewCustomers.setText("View Customers");
		btnViewCustomers.setBounds(474, 176, 150, 100);

	}

}
