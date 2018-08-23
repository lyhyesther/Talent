BottomSheetDialogFragment

Usage

1、Subclass BottomSheetDialogFragment
2、Override onCreateView.
3、Use one of the two versions of show to display the dialog. Notice BottomSheetDialogFragmentis a subclass of AppCompatFragment, 
which means you need to use Activity.getSupportFragmentManager().

Note: Don't call setOnCancelListener or setOnDismissListener on a BottomSheetDialogFragment, instead you
 can override onCancel(DialogInterface) or onDismiss(DialogInterface) if necessary.